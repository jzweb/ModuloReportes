<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clinica NovaSalud - Reportes | Reportes de Medicos</title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/scripts.js"></script>
</head>
<body>

   <div class="row" style="background-color:#d8dcdf;">
      <div class="container">
           <div class="col-md-1" style="padding-left:2%;">
                         <a href="/dashboard"><img src="img/back.png" style="width:40px;margin-top:40px;" alt="Volver"/></a>
           </div>
           <div class="col-md-11">
                 <h1>NovaSalud</h1>
                 <h2>Reportes de Médicos</h2>
                 <p><label>usuario:</label> ${user}&nbsp;|&nbsp;&nbsp;<a href="/closeSession"><img src="img/closeSession.png" style="width:15px;"/>Cerrar Session</a></p>
           </div>
      </div>
   </div>
   <div class="row" style="margin:2% 0;">
         <div class="container">
            <div class="col-md-1"></div>
            <div class="col-md-11" style="background-color:#25AE96">
                <form action="" method="post" id="boxForm">
                    <h2>Búsqueda de Médicos</h2>
                    <label>Filtro por:   </label> <input type="checkbox" name="date" id="date" value="0">&nbsp Fecha  <input type="checkbox" name="specialty" id="specialty" value="1"> Especialidad<br>
                    <div id="filter0" style="display:none">
                    <br><br>
                        <label>Especialidad: </label>
                         <select name="specialtydoc">
                                      <option value="cardiologia">Cardiologia</option>
                                      <option value="Gastroenterología">Gastroenterología</option>
                                      <option value="Endocrinología">Endocrinología</option>
                                      <option value="Geriatría">Geriatría</option>
                                      <option value="Hematología y hemoterapia">Hematología y hemoterapia</option>
                                      <option value="Infectología">Infectología</option>
                                      <option value="Medicina General">Medicina General</option>
                                      <option value="Nefrología">Nefrología</option>
                                      <option value="Neumología">Neumología</option>
                                      <option value="Neurología">Neurología</option>
                                      <option value="Nutriología">Nutriología</option>
                                      <option value="Oftalmología">Oftalmología</option>
                                      <option value="Oncología médica">Oncología médica</option>
                                      <option value="Pediatría">Pediatría</option>
                                      <option value="Psiquiatría">Psiquiatría</option>
                                      <option value="Rehabilitación">Rehabilitación</option>
                                      <option value="Reumatología">Reumatología</option>
                                      <option value="Toxicología">Toxicología</option>
                                      <option value="Urología">Urología</option>
                         </select><br><br>
                        <input type="submit" value="Buscar" id="filterSpecialty" class="btn btn-primary">
                    </div>
                    <div id="filter1" style="display:none">
                    <br><br>
                        <label>Fecha: </lable>
                        <br>MM<select name="month">
                              <option value="01">01</option>
                                     <option value="02">02</option>
                                     <option value="03">03</option>
                                     <option value="04">04</option>
                                     <option value="05">05</option>
                                     <option value="06">06</option>
                                     <option value="07">07</option>
                                     <option value="08">08</option>
                                     <option value="09">09</option>
                                     <option value="10">10</option>
                                     <option value="11">11</option>
                                     <option value="12">12</option>
                          </select>&nbsp;&nbsp;/&nbsp;&nbsp;
                          YYYY <select name="year">
                                 <option value="2013">2013</option>
                                 <option value="2014">2014</option>
                                 <option value="2015">2015</option>
                                 <option value="2016">2016</option>
                                 <option value="2017">2017</option>
                          </select><br><br>
                        <input type="submit" value="Buscar" id="filterDate" class="btn btn-primary">
                    </div>
                    <br>

                </from>
            </div>
         </div>
   </div>


</body>
</html>