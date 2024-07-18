<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
    .login-form{
        width: 400px;
        height: 300px;
        position: absolute;
        top: 50%;
        left:50%;
        border-radius: 3px;
        margin-right: -50%;
        transform: translate(-50%,-50%);
    } .v1{
        color: chartreuse;
       
    } #v2{
        background-color: orange;
        border-radius: 5px;
    
    }
</style>

</head>
<body style="background-color: aqua;">
   
        <div class="login-form bg-dark p-4">
          
            <h1 class="text-center v1">${login}</h1>
            <div class="text-danger text-center " id="v2">${errorMsg}</div>
            <div class="container-fluid m-4"></div>
    <form action="homePage">
        <input type="text"  class="form-control mt-3"  name="user" required placeholder="username">
        <input type="password" class="form-control mt-3"  name="pass" required placeholder="password">   
        <input type="submit"  class="btn btn-primary mt-3"  value="Submit">
    </form>
</div>
</div>
<script>
    
</script>
</body>
</html>