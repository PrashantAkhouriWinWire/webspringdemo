# Spring Boot
Springboot is an open-source framework for creating Production-Ready Applications.
This Spring Boot Tutorial will teach how to get started with Spring Boot and Java and create Production-ready Applications.

# Installation

Goto VSCode Extensions :
--  goto url : start.spring.io and setup using wizard
    OR 
- Install Java Extensions Pack
- Install SPring Boot Extension Pack
- Click on Create Project ( on SSpringboit extension pack)
   - select Maven
   - proceed with JAVA laates framework say 14

# Folder Structure
   pom.xml  # Configuration XML file containg springbbot and package dependecies liek packages.config or json
   - src
     | main
        | java\com\sbootdemo\demoapp # create your .java @controller (Web) or @restconttroller (API) files  
        | resources
              |  static      # for static cssand js under /css and /js folders
              |  templates   # for html view files
              application.properties # this is App or Server configuirations
         

 # Sprint Boot Annotations

  @SpringBootApplication -- startup main ()
  @Controller  -- Web return "html template view"
     FOr Controller to return view as html from src/main/resources/templates folder 
     in pom.xml add below web and thymeleaaf dependencies -  
     <dependency>
		<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
			<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>


  @RestController -- API return
    [ Methods ]
    @Mapping(,method=GET  or POST)
       or directly
    @GetMapppng
    @PostMapping

    @SpringBootApplication

@Service

@Repository

@Autowired

@Transactional

@Async

@Override
---

# SprintBoot Web Workflow

Browser / Client
      ↓ HTTP Request
@Controller / @RestController
      ↓
@Service (Business Logic)
      ↓
@Repository (DB Access)
      ↓
@Response (HTML or JSON)

# AUto Restart or Build on changes
Add dependency in pom.xml 
<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<scope>runtime</scope>
		</dependency>