# student-management-system


    /*
        //Example of how to add the HATEOAS
        import org.springframework.hateoas.EntityModel;
        import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));
     */

// connect to mysqlsh
\connect social-media-user@localhost:3366
provide the password
\use social-media-database
\use social-media-database

docker run --detach
--env MYSQL_ROOT_PASSWORD=dummypassword
--env MYSQL_USER=social-media-user
--env MYSQL_PASSWORD=dummypassword
--env MYSQL_DATABASE=social-media-database
--name mysql
--publish 3306:3306
mysql:8-oracle


How Spring Security works
============================
There is something call filter chains which intercepts all the requests that are comming

Filter Chains:
1) All requests should be authenticated
2) If a request is not authenticated, a web page is shown
3) CSRF -> POST, PUT