$(document).ready(function(){
    $('#date').click(function(){
        if (this.checked) {
            $('#yearBorn').prop('checked', false);
            $('#filter0').show();
            $('#filter1').hide();
        }else{
            $('#filter1').hide();
            $('#filter0').hide();
        }
    })

    $('#yearBorn').click(function(){
        if(this.checked){
           $('#date').prop('checked',false);
           $('#filter1').show();
           $('#filter0').hide();
        }else{
            $('#filter0').hide();
            $('#filter1').hide();
        }
    })

    //poblar select Year inicio
    var list = $("#dateYearInicio");
    var limitYear = 2016;
    for(var i = 1900; i <= limitYear; i++) {
     list.append('<option value="'+i+'">'+i+'</option>');
    }

    //poblar select Year inicio
        var list = $("#dateYearFin");
        var limitYear = 2016;
        for(var i = 1900; i <= limitYear; i++) {
         list.append('<option value="'+i+'">'+i+'</option>');
        }


    //funcion para validar fechas cuando se produzcan cambion en el rango de fechas
    $('select').on('change', function() {
      verifyDates();
    })

    // Funcion valida que el rango de fechas a introducir no sean incorrectas. El inicio siempre mayor a la fecha final a buscar.
    function verifyDates(){
            if($('#dateYearInicio').val() > $('#dateYearFin').val()){
             $('#filterYearborn').prop("disabled",true);
             alert("Porfavor el Año de inicio debe ser menor que la Fecha final.");
            }else{
                    if($('#dateMonthInicio').val() > $('#dateMonthFin').val()){
                         $('#filterYearborn').prop("disabled",true);
                         alert("Porfavor el Mes de inicio debe ser menor que la Fecha final.");
                     }
            $('#filterYearborn').prop("disabled",false);
            }
    }


    $('#filterDate').click(function(){
                  $('#boxForm').attr('action', '/report-patients-date');
    });

    $('#filterYearborn').click(function(){
                 $('#boxForm').attr('action', '/report-patients-yearborn');
     });

});