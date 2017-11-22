 <!DOCTYPE html>
 <html lang="en">
 <head>
     <meta charset="UTF-8">
     <title>Clinica NovaSalud | Resultado reporte de Pacientes</title>
     <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <script src="js/scripts.js"></script>
 </head>
 <body>

    <div class="row" style="background-color:#d8dcdf;">
       <div class="container">
            <div class="col-md-1" style="padding-left:2%;">
                          <a href="/reportspatients"><img src="img/back.png" style="width:40px;margin-top:40px;" alt="Volver"/></a>
            </div>
            <div class="col-md-11">
                  <h1>NovaSalud</h1>
                  <h2>Reporte de Pacientes que nacieron entre ${date1Find} y ${date2Find}</h2>
                  <p><label>usuario:</label> ${user}&nbsp;|&nbsp;&nbsp;<a href="/closeSession"><img src="img/closeSession.png" style="width:15px;"/>Cerrar Session</a></p>
            </div>
       </div>
    </div>
     <#if listPatients?has_content>
        <div class="row">
                          <div class="container">
                               <div class="col-md-1"></div>
                               <div class="col-md-11"><a href="/reportPatientDateBornPrint/${date1Find}/${date2Find}"><img src="img/pdf.png" style="width:20px"/></a></div>
                           </div>
                  </div>
                  <div class="row">
                       <div class="container">
                            <div class="col-md-1"></div>
                            <div class="col-md-11">
                                   <table class="table">
                                       <thead>
                                         <tr>
                                           <th>Id</th>
                                           <th>Dni</th>
                                           <th>Nombre paciente</th>
                                           <th>Fecha Nacimiento</th>
                                           <th>Dirección</th>
                                           <th>Correo</th>
                                           <th>Telefono</th>
                                           <th>Sexo</th>
                                         </tr>
                                       </thead>
                                       <tbody>
                                           <#list listPatients as patient>
                                         <tr>
                                            <td>${patient.id}</td>
                                            <td>${patient.dni}</td>
                                            <td>${patient.name}, ${patient.lastName}</td>
                                            <td>${patient.dateofbirth}</td>
                                            <td>${patient.address}</td>
                                            <td>${patient.email}</td>
                                            <td>${patient.telephone}</td>
                                            <td>${patient.sex}</td>
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
                             <h1>No existen Pacientes</h1>
                      </div>
                  </div>
     </div>
     </#if>


 </body>
 </html>