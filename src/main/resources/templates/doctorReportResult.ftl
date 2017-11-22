<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica X - Reportes | Resultado reporte de Medicos</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/scripts.js"></script>
</head>
<body>

   <div class="row" style="background-color:#d8dcdf;">
      <div class="container">
           <div class="col-md-1" style="padding-left:2%;">
                         <a href="/reportsdoctors"><img src="img/back.png" style="width:40px;margin-top:40px;" alt="Volver"/></a>
           </div>
           <div class="col-md-11">
                 <h1>NovaSalud</h1>
                 <h2>Reporte de Médicos especialistas en ${doctorSpecialty}</h2>
                 <p><label>usuario:</label> ${user}&nbsp;|&nbsp;&nbsp;<a href="/closeSession"><img src="img/closeSession.png" style="width:15px;"/>Cerrar Session</a></p>
           </div>
      </div>
   </div>
 <#if listDoctors?has_content>
       <div class="row">
               <div class="container">
                    <div class="col-md-1"></div>
                    <div class="col-md-11"><a href="/reportDoctorsEspecialtyPrint/${doctorSpecialty}"><img src="img/pdf.png" style="width:20px"/></a></div>
                </div>
       </div>
       <div class="row">
            <div class="container">
                 <div class="col-md-1"></div>
                 <div class="col-md-11">
                        <table class="table">
                            <thead>
                              <tr>
                                <th>Especialidad</th>
                                <th>Id</th>
                                <th>Medico</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th>Sexo</th>
                              </tr>
                            </thead>
                            <tbody>

                              <#list listDoctors as doctor>
                              <tr>
                                <td>${doctor.specialty}</td>
                                <td>${doctor.id}</td>
                                <td>${doctor.name}, ${doctor.lastname}</td>
                                <td>${doctor.telephone}</td>
                                <td>${doctor.email}</td>
                                <td>${doctor.sex}</td>
                              </tr>
                              </#list>


                            </tbody>
                          </table>
                 </div>
            </div>
       </div>
    <#else>
    <div class="row">
                <div class="container">
                     <div class="col-md-1"></div>
                     <div class="col-md-11">
                            <h1>No existen doctores</h1>
                     </div>
                 </div>
    </div>
    </#if>


</body>
</html>