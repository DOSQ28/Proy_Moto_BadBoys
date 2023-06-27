<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<jsp:include page="arriba.jsp"/>
<body class="contact-page">
    <div class="main-body">
        <div class="container">
            <div class="row">

                <div class="main-page">
                    <jsp:include page="menu.jsp"/>                    
                    <div class="content-main contact-content">                        
                        <div class="contact-content-upper">
                            <div class="row">
                                <jsp:include page="menucito.jsp"/>
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <div class="gallery_title">
                                        <h3>MOTOCICLETAS</h3>
                                        <h4>REGISTRE</h4>
                                    </div>    
                                </div>                            
                            </div>

                            <div class="row">                                                                  
                                <div class="col-sm-12 col-md-6 contact_left">                                            
                                    <form class="form-horizontal" method="post" action="MotocicletaControlador">

                                        <div class="form-group">                                    
                                                <input type="hidden" class="form-control" id="name" name="id" placeholder="CI..." value="${motocicleta.cod_moto}">
                                            <input type="text" class="form-control" id="name" name="descripcion" placeholder="DESCRIPCIOM..." value="${motocicleta.descripcion}">
                                        </div>
                                        <!--<div class="form-group">                                    
                                            <input type="file" class="form-control" id="name" name="img" placeholder="NRO° DE PLACA..." value="${motocicleta.img}">
                                        </div>-->
                                        <div class="form-group">                                    
                                            <input type="text" class="form-control" id="name" name="placa" placeholder="NRO° DE PLACA..." value="${motocicleta.placa}">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" id="email" name="marca" placeholder="MARCA..." value="${motocicleta.marca}">      
                                        </div>

                                        <div class="form-group">
                                            <input type="text" class="form-control" id="subject" name="tipo" placeholder="TIPO..." value="${motocicleta.tipo}">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" id="subject" name="color" placeholder="COLOR..." value="${motocicleta.color}">        
                                        </div>
                                        <div class="form-group">
                                            <input type="number" class="form-control" id="subject" name="precio" placeholder="PRECIO..." value="${motocicleta.precio}">        
                                        </div>
                                                                                    
                                        <div class="form-group">
                                            <input id="submit" name="submit" type="submit" value="ENVIAR" class="btn view_more btn-submit">
                                        </div>            

                                    </form>    
                                </div> <!-- .contact-left -->

                                <jsp:include page="Contactenos.jsp"/>
                            </div> <!-- .row -->
                        </div>

                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <div id="google-map"></div>
                            </div>                            
                        </div>

                    </div> <!-- .contact-content -->
                </div> <!-- .main-page -->
            </div> <!-- .row -->

            <footer class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 footer">
                    <p class="copyright">Copyright © 2016 Company Name

                        | Design: <a rel="nofollow" href="http://www.templatemo.com" target="_parent">template mo</a></p>
                </div>    
            </footer>  <!-- .row -->   

        </div> <!-- .container -->
    </div> <!-- .main-body -->

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        /* Google map
         ------------------------------------------------*/
        var map = '';
        var center;

        function initialize() {
            var mapOptions = {
                zoom: 16,
                center: new google.maps.LatLng(13.758468, 100.567481),
                scrollwheel: false
            };

            map = new google.maps.Map(document.getElementById('google-map'), mapOptions);

            google.maps.event.addDomListener(map, 'idle', function () {
                calculateCenter();
            });

            google.maps.event.addDomListener(window, 'resize', function () {
                map.setCenter(center);
            });
        } // initialize

        function calculateCenter() {
            center = map.getCenter();
        }

        function loadGoogleMap() {
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' + 'callback=initialize';
            document.body.appendChild(script);
        }

        // DOM is ready.
        $(document).ready(function () {
            loadGoogleMap();
        });
    </script>
</body>
</html>
