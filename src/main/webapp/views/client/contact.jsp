<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <!-- Basic -->

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <!-- Site Metas -->
    <title>Cake Shop</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <!-- Site Icons -->
    <link
      href="<c:url value='/template/client/images/favicon.ico' />"
      rel="shortcut icon"
      type="image/x-icon"
    />
    <link
      href="<c:url value='/template/client/images/apple-touch-icon.png' />"
      rel="apple-touch-icon"
    />

    <!-- Bootstrap CSS -->
    <link
      href="<c:url value='/template/client/css/bootstrap.min.css' />"
      rel="stylesheet"
    />
    <!-- Site CSS -->
    <link
      href="<c:url value='/template/client/css/style.css' />"
      rel="stylesheet"
    />
    <!-- Responsive CSS -->
    <link
      href="<c:url value='/template/client/css/responsive.css ' />"
      rel="stylesheet"
    />
    <!-- Custom CSS -->
    <link
      href="<c:url value='/template/client/css/custom.css ' />"
      rel="stylesheet"
    />

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- Start Top Search -->
    <div class="top-search">
      <div class="container">
        <div class="input-group">
          <span class="input-group-addon"><i class="fa fa-search"></i></span>
          <input type="text" class="form-control" placeholder="Search" />
          <span class="input-group-addon close-search"
            ><i class="fa fa-times"></i
          ></span>
        </div>
      </div>
    </div>
    <!-- End Top Search -->

    <!-- Start All Title Box -->
    <div class="all-title-box">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <h2>Contact Us</h2>
            <ul class="breadcrumb">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Contact Us</li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Contact Us  -->
    <div class="contact-box-main">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-sm-12">
            <div class="contact-form-right">
              <h2>NH???N G???I T???I CH??NG T??I</h2>
              <p>
                R???t mong nh???ng ph???n h???i, ?? ki???n ????ng g??p c???a qu?? kh??ch ????? shop
                c?? th??? ho??n thi???n h??n n???a ????p ???ng nhu c???u v?? l??m h??i l??ng t???t c???
                kh??ch h??ng c???a NamShopCake
              </p>
              <form
                action="${pageContext.request.contextPath }/sendmail"
                id="contactForm"
                method="post"
              >
                <div class="row">
                  <div class="col-md-12">
                    <div class="form-group">
                      <input
                        type="text"
                        class="form-control"
                        id="name"
                        name="name"
                        placeholder="Your Name"
                        required
                        data-error="Please enter your name"
                      />
                      <div class="help-block with-errors"></div>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <div class="form-group">
                      <input
                        type="text"
                        placeholder="Your Email"
                        id="email"
                        class="form-control"
                        name="gmail"
                        required
                        data-error="Please enter your email"
                      />
                      <div class="help-block with-errors"></div>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <div class="form-group">
                      <input
                        type="text"
                        class="form-control"
                        id="subject"
                        name="text"
                        placeholder="Subject"
                        required
                        data-error="Please enter your Subject"
                      />
                      <div class="help-block with-errors"></div>
                    </div>
                  </div>
                  <div class="col-md-12">
                    <div class="form-group">
                      <textarea
                        class="form-control"
                        id="message"
                        name="message"
                        placeholder="Your Message"
                        rows="4"
                        data-error="Write your message"
                        required
                      ></textarea>
                      <div class="help-block with-errors"></div>
                    </div>
                    <div class="submit-button text-center">
                      <button class="btn hvr-hover" id="submit" type="submit">
                        Send Message
                      </button>
                      <div id="msgSubmit" class="h3 text-center hidden"></div>
                      <div class="clearfix"></div>
                    </div>
                  </div>
                </div>
              </form>
              <div>
                <i>${hoanhthanh }</i>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-12">
            <div class="contact-info-left">
              <h2>Th??ng tin li??n h???</h2>

              <ul>
                <li>
                  <p>
                    <i class="fas fa-map-marker-alt"></i>?????a ch???: 371 Nguy???n
                    Ki???m, P.3<br />Qu???n G?? V???p,<br />
                    TPHCM
                  </p>
                </li>
                <li>
                  <p>
                    <i class="fas fa-phone-square"></i>??i???n tho???i:
                    <a href="tel:+1-888705770">0868014219</a>
                  </p>
                </li>
                <li>
                  <p>
                    <i class="fas fa-envelope"></i>Gmail:
                    <a href="mailto:contactinfo@gmail.com"
                      >nhom9gdu@gmail.com</a
                    >
                  </p>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- End Cart -->

    <jsp:include page="footer.jsp"></jsp:include>

    <!-- ALL JS FILES -->
    <script src="<c:url value='/template/client/js/jquery-3.2.1.min.js'/>"></script>
    <script src="<c:url value='/template/client/js/popper.min.js' />"></script>
    <script src="<c:url value='/template/client/js/bootstrap.min.js'/>"></script>
    <!-- ALL PLUGINS -->
    <script src="<c:url value='/template/client/js/jquery.superslides.min.js'/> "></script>
    <script src="<c:url value='/template/client/js/bootstrap-select.js'/> "></script>
    <script src="<c:url value='/template/client/js/inewsticker.js'/> "></script>
    <script src="<c:url value='/template/client/js/bootsnav.js'/>"></script>
    <script src="<c:url value='/template/client/js/images-loded.min.js '/>"></script>
    <script src="<c:url value='/template/client/js/isotope.min.js'/> "></script>
    <script src="<c:url value='/template/client/js/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/template/client/js/baguetteBox.min.js'/> "></script>
    <script src="<c:url value='/template/client/js/form-validator.min.js'/> "></script>
    <script src="<c:url value='/template/client/js/contact-form-script.js'/> "></script>
    <script src="<c:url value='/template/client/js/custom.js'/> "></script>
  </body>
</html>
