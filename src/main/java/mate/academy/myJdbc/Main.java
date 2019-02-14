package mate.academy.myJdbc;

import mate.academy.myJdbc.dao.DeveloperDao;
import mate.academy.myJdbc.dao.DeveloperDaoImpl;
import mate.academy.myJdbc.dao.ProjectDaoImpl;
import mate.academy.myJdbc.model.Developer;
import mate.academy.myJdbc.model.Project;
import mate.academy.myJdbc.model.Skill;
import mate.academy.myJdbc.service.DeveloperService;
import mate.academy.myJdbc.service.DeveloperServiceImpl;
import mate.academy.myJdbc.service.ProjectService;
import mate.academy.myJdbc.service.ProjectServiceImpl;

import java.sql.Connection;
import java.sql.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Connection connection = MyConnectionUtil.getConnection();
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));
        ProjectService projectService = new ProjectServiceImpl(new ProjectDaoImpl(connection));

//        System.out.println("Sum of developers salary for project Astra is: "
//                + projectService.getSumSalaryForProject("Astra"));
//
//        System.out.println("All devs on project Astra:");
//        Set<Developer> devsOnProject = projectService.getAllDevsOnProject("Astra");
//        System.out.println(devsOnProject);
//
//        System.out.println("All Java devs:");
//        Set<Developer> javaDevs = developerService.getAllJavaDevs();
//        System.out.println(javaDevs);
//
//        System.out.println("All middle devs:");
//        Set<Developer> middleDevs = developerService.getAllMiddleDevs();
//        System.out.println(middleDevs);
//
//        System.out.println("All projects:");
//        Set<Project> allProjects = projectService.getAllProjects();
//        System.out.println(allProjects);
//
//        Developer dev = new Developer("Onotole", 50, 3000);
//        Skill skill = new Skill("Java", "Senior");
//        dev.addSkill(skill);
//        Project project = new Project.Builder().setName("Astra").build();
//        dev.addProject(project);
//        developerService.addNewDeveloper(dev);
//
//        Developer dev2 = new Developer(9, "Tolya", 33, 9000);
//        Skill skill = new Skill("Java", "Middle");
//        dev2.addSkill(skill);
//        Project project = new Project.Builder().setName("Aqua").build();
//        dev2.addProject(project);
//        developerService.updateDeveloper(dev2);

//        developerService.delete(8);

//        Developer findedDeveloper = developerService.findDeveloper(1);
//        System.out.println(findedDeveloper);

//        Developer dev2 = new Developer(5, "Ivan", 33, 9000);
//        Project project = new Project
//                .Builder()
//                .setName("Temptus")
//                .setBirthday(new Date(2017-01-01))
//                .setCost(250000)
//                .build();
//        project.addDeveloper(dev2);
//        projectService.addProject(project);

//        Project project = projectService.findProject(2);
//        System.out.println(project);

//        Project project = projectService.findProject(2);
//        project.setName("Astartes");
//        projectService.updateProject(project);

//        projectService.delete(4);
    }
}