$(document).ready(function() {

   $("#login").click(function(){
     $('.dropdown-menu').css('display','block');
   });
   $("#close").click(function(){
      $('.dropdown-menu').css('display','none');
   });

   // Selection option : Libro
   var listado = document.getElementById('select-libro');
   if(listado!=null){
       listado.addEventListener('change',function(){
              var selectedOption = this.options[listado.selectedIndex];
              console.log(selectedOption.value + ': ' + selectedOption.text);
                var id=selectedOption.value;
                var idv=parseInt(id)
                $.ajax({
                   type: 'POST',
                   url:'precio/',
                   data:{"id": idv},
                   success: function(data){
                         $("#precio").val(data);
                         $("#cantidad").val(0);
                         $("#total").val(0);
                   }
                });
           });

   }

   //Seleccionar la cantidad de libros
   var listCant = document.getElementById('cantidad');
      if(listCant!=null){
          listCant.addEventListener('change',function(){
                 $("#total").val(0);
                 var precio= $("#precio").val();
                 var precioN = parseInt(precio);
                 var cantidad=$("#cantidad").val();
                 var cantidadN = parseInt(cantidad);
                 var totalL= precio * cantidad;
                  $("#total").val(totalL);
              });

      }

   $(window).on('click', function() {
     $("#alert").css({"display": "none"});
   });



});