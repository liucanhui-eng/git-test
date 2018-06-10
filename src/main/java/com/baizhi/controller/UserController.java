package com.baizhi.controller;

import com.baizhi.annotation.NameAnnotation;
import com.baizhi.entity.ComboboxData;
import com.baizhi.entity.MapDate;
import com.baizhi.entity.TableDate;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "userCount")
    @ResponseBody
    public TableDate userCount() {
        return service.queryByDate();
    }


    @RequestMapping(value = "userMap")
    @ResponseBody
    public MapDate showUserMap() {
        return service.queryByAreaAndSex();
    }


    @RequestMapping(value = "queryUserByPage")
    @ResponseBody
    public Map<String, Object> queryUserByPage(String page, String rows) {
        System.out.println(page + "====================" + rows);

        List<User> users = service.queryUserByPage(page, rows);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("total", service.queryUserCount());//total数据库总条数
        map.put("rows", users);
        return map;
    }


    @RequestMapping(value = "ShowField")
    @ResponseBody
    public List<ComboboxData> ShowField() {
        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        List<ComboboxData> data = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        for (Field field : fields) {
            values.add(field.getName());
            NameAnnotation annotation = field.getAnnotation(NameAnnotation.class);
            names.add(annotation.name());
        }
        for (int i = 0; i < names.size(); i++) {
            data.add(new ComboboxData(values.get(i), names.get(i)));
        }
        return data;
    }

    @RequestMapping(value = "export")
    public void export(String filed, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] fields = filed.split(",");
        String[] titles = request.getParameter("text").split(",");
        System.out.println("title" + request.getParameter("text"));
//        获取所有用户
        int count = service.queryUserCount();
        List<User> users = service.queryUserByPage(1 + "", 10 + "");
//      获取user类对象
        Class<User> userClass = User.class;

        //创建excel工作对象
        Workbook workbook = new HSSFWorkbook();
        //创建表格
        Sheet sheet = workbook.createSheet("用户信息");
        //表头
        Row row = sheet.createRow(0);
        for (int j = 0; j < titles.length; j++) {
            Cell cell = row.createCell(j);
            cell.setCellValue(titles[j]);
        }


        for (int i = 0; i < users.size(); i++) {
            //创建一行
            row = sheet.createRow(i + 1);
            for (int j = 0; j < fields.length; j++) {//遍历属性
                //每次获取一个单元格
                Cell cell = row.createCell(j);
                //获取属性名
                String fieldName = fields[j];
                //获取方法名
                String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                //获取类对象
                Class<? extends User> aClass = users.get(i).getClass();
                //获取方法对象
                Method method = aClass.getDeclaredMethod(methodName, null);
                //调用方法
                Object invoke = method.invoke(users.get(i), null);
                //返回值类型判断
                if (invoke.getClass() == Date.class) {
                    Date date = (Date) invoke;
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    String s = format.format(date);
                    cell.setCellValue(s);
                } else if (invoke.getClass() == String.class) {
                    cell.setCellValue((String) invoke);
                } else {
                    throw new RuntimeException("没有这个类型异常");
                }
            }
        }
        //表格填充完毕准备输出

        //设置响应类型
        response.setContentType(MediaType.TEXT_PLAIN_VALUE);
        //设置响应头，对文件进行编码
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String fileName = URLEncoder.encode("用户信息-导出于-" + date + ".xls", "utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        workbook.write(response.getOutputStream());
    }


    @RequestMapping(value = "inputExcel")
    @ResponseBody
    public String inputExcel(MultipartFile file) throws Exception {
        System.out.println("================================================");

        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        Workbook workbook = new HSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheet("用户信息");
        HashMap<String, Field> map = new HashMap<>();
        Row row = sheet.getRow(0);
        List<String> titles = new ArrayList<>();
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            titles.add(cell.getStringCellValue());
        }
        for (Field field : fields) {
            String name = field.getAnnotation(NameAnnotation.class).name();
            if (titles.contains(name)) {
                map.put(titles.get(titles.indexOf(name)), field);
            }
        }

        List<User> users = new ArrayList<>();
        int count = sheet.getLastRowNum();
        for (int i = 1; i <= count; i++) {
            User user = new User();
            row = sheet.getRow(i);
            //Thread.sleep(100000);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                if (titles.indexOf("注册日期") == j) {
                    String value = cell.getStringCellValue();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    user.setDate(format.parse(value));
                }
                //for (String title : titles) {

                if (titles.get(j).equals("注册日期")) continue;
                Field field = map.get(titles.get(j));
                String methodName = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                user.getClass().getMethod(methodName, String.class).invoke(user, cell.getStringCellValue());
                // }
            }
            users.add(user);

            System.out.println("\n\n============================测试===============================\n\n");
            for (User user1 : users) {
                System.out.println(user1);
            }
            System.out.println("\n\n============================测试===============================\n\n");

        }
        return "success";
    }


//注册接口
    @RequestMapping(method = RequestMethod.GET,value = "register")
    @ResponseBody
    public Map<String,String> register(String phone, String password){
        return service.register(phone,password);
    }


    //修改接口
    @RequestMapping(method = RequestMethod.GET,value = "motify")
    @ResponseBody
    public Object motify(User user){
        return service.motify(user);
    }
    //精钢道友
    @RequestMapping(method = RequestMethod.GET,value = "member")
    @ResponseBody
    public List<User> member(String uid){
        System.out.println(uid+"=======");
        return service.randomUser(uid);
    }





}
