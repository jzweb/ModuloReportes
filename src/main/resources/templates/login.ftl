<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica NovaSalud - Reportes | Login</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#e9ebec;>

   <div class="row" >
      <div class="container">
       <div class="col-md-4 col-md-offset-4" style="margin-top:10%">
           <br><br>

           <center>
           <img src="img/medicSimbol.png" style="width:80px;"><br>
           <h3>NovaSalud | Reportes</h3></center>
           <form action="/controlLogin" method="POST">
               <input type="text" placeholder="email" class="form-control" name="user"><br>
               <input type="password" placeholder="password" class="form-control" name="pass"><br>
               <button type="submit" class="btn btn-primary">Ingresar</button>

           </form>
       </div>
      </div>
   </div>

</body>
</html>