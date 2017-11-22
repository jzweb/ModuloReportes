$(document).ready(function(){
       $('#date').click(function(){
           if (this.checked) {
               $('#specialty').prop('checked', false);
               $('#filter1').show();
               $('#filter0').hide();
               $('#table1').hide();
               $('#table2').show();
           }else{
               $('#filter0').hide();
               $('#table2').hide();
           }
       })

       $('#specialty').click(function(){
           if(this.checked){
              $('#date').prop('checked',false);
              $('#filter0').show();
              $('#filter1').hide();
              $('#table1').show();
              $('#table2').hide();
           }else{
               $('#filter1').hide();
               $('#table1').hide();
           }
       })

       $('#filterSpecialty').click(function(){
          $('#boxForm').attr('action', '/report-doctors-specialty');
       });

       $('#filterDate').click(function(){
                 $('#boxForm').attr('action', '/report-doctors-date');
              });
   });