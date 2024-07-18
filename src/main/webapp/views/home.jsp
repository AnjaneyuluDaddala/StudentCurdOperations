<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Login Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
    table,th,td{
        border: 3px solid green;
        border-collapse: collapse;
        padding: 10px;
    }
    
</style>
</head>
<body style="background-color: coral;">

    <div class="container-fluid mt-4"> 

        <h1 class="text-center text-success"  >Welcome to HomePage  Mr.${name}</h1>
    <section> 
    <div class="mt-3 p-2 ">
        <li><a href="showStudents">Student</a></li>
        <h2>${students}</h2>
    
        <h1>Student List</h1>
        <div class="container-fluid">
            <div class="float-start">
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolores quam culpa eligendi unde ducimus consectetur animi numquam itaque tempore asperiores, deserunt expedita corporis temporibus architecto fugit adipisci nostrum aut nam! 
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Alias, laudantium aut numquam repudiandae laboriosam tenetur in nisi deleniti quibusdam a error, neque eligendi quasi ut qui rerum non facere praesentium.
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Nihil, maxime in? Nobis tenetur vero eum modi illo qui. Fugiat illum nemo eos molestiae eaque libero sapiente, odio maiores deserunt natus!
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis dolorem maxime exercitationem aliquid nesciunt alias. Eius, corporis libero corrupti perferendis minima debitis nesciunt quo numquam, architecto suscipit harum, sint voluptatem?
            </p>
        </div>
       
        <table class="float-end" border="3">
           <thread>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>school</th>
                <th>fee</th>
              
            </tr>
        </thread>
           
            <tbody>
                <tr th:each="student:${students}">  
                <td th:text="${student.id}"></td>  
                <td th:text="${student.name}"></td>  
                <td th:text="${student.school}"></td>  
                <td th:text="${student.fee}"></td>    
                </tr>  
            </tbody>
                
        </table>
       
    </div>
    </div>   
</section>
</div>
</body>
<footer>

</footer>
</html>