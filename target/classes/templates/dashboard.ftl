<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica NovaSalud - Reportes | Dashboard</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style-dashboard.css">
</head>
<body>

   <div class="row" style="background-color:#d8dcdf;">
      <div class="container">
           <div class="col-md-12">
                 <h1>NovaSalud</h1>
                 <h2>Sistema de Reportes</h2>
                 <p><label>usuario:</label> ${user}&nbsp;|&nbsp;&nbsp;<a href="/closeSession"><img src="img/closeSession.png" style="width:15px;"/>Cerrar Session</a></p>
           </div>
   </div>
   </div>
   <div class="row" style="margin:2% 0;">
         <div class="container">

          <div class="col-md-5">
                <div class = "thumbnail">
                     <img src = "img/doctor.png" alt = "pic1">
                </div>

                <div class = "caption">
                                   <center><p>
                                      <a href = "/reportsdoctors" class = "btn btn-primary" role = "button">
                                         Reportes de Medicos
                                      </a>
                                   </p></center>
                </div>
          </div>
          <div class="col-md-2"></div>
           <div class="col-md-5">
                          <div class = "thumbnail">
                               <img src = "img/patient.png" alt = "pic2">
                          </div>

                          <div class = "caption">
                                             <center><p>
                                                <a href = "/reportspatients" class = "btn btn-primary" role = "button">
                                                   Reportes de Pacientes
                                                </a>

                                             </p></center>
                          </div>
                    </div>

         </div>
   </div>


</body>
</html>

<!--
 	Reporte de Médicos por Especialidad
 	Reporte de Médicos que atendieron a una determinada fecha
 	Reporte de Pacientes Atendidos a una determinada Fecha
 	Reporte de Pacientes a un determinado rango de fecha de nacimiento.

-->