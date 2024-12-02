package org.example;

import javax.swing.*;
import java.awt.*;

public class ManagementSystem {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public void initUI() {
        frame = new JFrame("学生成绩管理系统");
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 使用卡片布局切换面板
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // 添加各功能模块面板
        mainPanel.add(createWelcomePanel(), "welcome");
        mainPanel.add(createStudentPanel(), "studentManagement");
        mainPanel.add(createTeacherPanel(), "teacherManagement");
        mainPanel.add(createCoursePanel(), "courseManagement");
        mainPanel.add(createStudentCoursePanel(), "studentCourse");
        mainPanel.add(createTeacherGradePanel(), "teacherGrade");
        mainPanel.add(createStudentGradePanel(), "studentGrade");

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setJMenuBar(createMenuBar());
        frame.setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu studentMenu = new JMenu("学生管理");
        JMenu teacherMenu = new JMenu("教师管理");
        JMenu courseMenu = new JMenu("课程管理");

        JMenuItem manageStudents = new JMenuItem("学生信息维护");
        JMenuItem manageTeachers = new JMenuItem("教师信息维护");
        JMenuItem manageCourses = new JMenuItem("课程信息维护");
        JMenuItem studentCourses = new JMenuItem("学生选课信息");
        JMenuItem teacherGrades = new JMenuItem("任课教师操作成绩");
        JMenuItem studentGrades = new JMenuItem("学生查询课程成绩");

        // 添加事件监听
        manageStudents.addActionListener(e -> switchPanel("studentManagement"));
        manageTeachers.addActionListener(e -> switchPanel("teacherManagement"));
        manageCourses.addActionListener(e -> switchPanel("courseManagement"));
        studentCourses.addActionListener(e -> switchPanel("studentCourse"));
        teacherGrades.addActionListener(e -> switchPanel("teacherGrade"));
        studentGrades.addActionListener(e -> switchPanel("studentGrade"));

        // 构建菜单
        studentMenu.add(manageStudents);
        studentMenu.add(studentCourses);
        studentMenu.add(studentGrades);

        teacherMenu.add(manageTeachers);
        teacherMenu.add(teacherGrades);

        courseMenu.add(manageCourses);

        menuBar.add(studentMenu);
        menuBar.add(teacherMenu);
        menuBar.add(courseMenu);

        return menuBar;
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("欢迎使用学生成绩管理系统！", SwingConstants.CENTER));
        return panel;
    }

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("学生信息维护", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"学生ID", "姓名", "年龄", "班级"};
        Object[][] data = {
                {"1", "张三", "20", "软件工程"},
                {"2", "李四", "21", "信息安全"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 添加按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("添加学生"));
        buttonPanel.add(new JButton("编辑学生"));
        buttonPanel.add(new JButton("删除学生"));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTeacherPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("教师信息维护", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"教师ID", "姓名", "职称"};
        Object[][] data = {
                {"1", "王老师", "教授"},
                {"2", "赵老师", "副教授"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 添加按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("添加教师"));
        buttonPanel.add(new JButton("编辑教师"));
        buttonPanel.add(new JButton("删除教师"));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("课程信息维护", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"课程ID", "课程名称", "学分"};
        Object[][] data = {
                {"1", "数据结构", "4"},
                {"2", "操作系统", "3"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 添加按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("添加课程"));
        buttonPanel.add(new JButton("编辑课程"));
        buttonPanel.add(new JButton("删除课程"));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createStudentCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("学生选课信息", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"学生ID", "学生姓名", "选修课程"};
        Object[][] data = {
                {"1", "张三", "数据结构"},
                {"2", "李四", "操作系统"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createTeacherGradePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("任课教师操作课程成绩", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"学生ID", "学生姓名", "课程名称", "成绩"};
        Object[][] data = {
                {"1", "张三", "数据结构", "95"},
                {"2", "李四", "操作系统", "89"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 添加按钮
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("修改成绩"));
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createStudentGradePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("学生查询课程成绩", SwingConstants.CENTER), BorderLayout.NORTH);

        // 模拟表格展示
        String[] columns = {"课程名称", "成绩"};
        Object[][] data = {
                {"数据结构", "95"},
                {"操作系统", "89"}
        };
        JTable table = new JTable(data, columns);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        return panel;
    }

    private void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
}
