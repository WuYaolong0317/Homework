package com.example.demo.controller;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RestController
public class index {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public List<Map<String, Object>> workersList(){
        String sql1 = "select * from workers";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql1);
        System.out.println(result.toString());
        return result;
    }

    @GetMapping("/listinsert")
    public List<Map<String, Object>> workersListinsert(){
        String sql1 = "select * from workers";
        String sql2 = "insert INTO workers VALUES ('003', '王毅', '助理工程师', 33);";
        String sql3 = "insert INTO workers VALUES ('004', '李鑫龙', '实习生', 23)";
        jdbcTemplate.execute(sql2);
        jdbcTemplate.execute(sql3);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql1);
        System.out.println(result.toString());
        return result;
    }

    @GetMapping("/listupdate")
    public List<Map<String, Object>> workersListupdate(){
        String sql1 = "select * from workers";
        String sql2 = "update workers set ID='003' where ID='004';";
        jdbcTemplate.execute(sql2);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql1);
        System.out.println(result.toString());
        return result;
    }

    @GetMapping("/listdelete")
    public List<Map<String, Object>> workersListdelete(){
        String sql1 = "select * from workers";
        String sql2 = "delete from workers where ID = '003'";
        jdbcTemplate.execute(sql2);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql1);
        System.out.println(result.toString());
        return result;
    }

    @GetMapping("/listselect")
    public List<Map<String, Object>> workersListselect(){
        String sql1 = "select * from workers order by ID desc";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql1);
        System.out.println(result.toString());
        return result;
    }
}
