<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Thong tin toa nha</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try { ace.settings.check('breadcrumbs', 'fixed') } catch (e) { }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home Admin</a>
                </li>
                <li class="active">Thong tin toa nha</li>
            </ul><!-- /.breadcrumb -->


        </div>

        <div class="page-content" style="font-family: 'Times New Roman', Times, serif;">

            <div class="page-header">
                <h1>
                    Thong tin toa nha
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->

            <!-- Main page -->
            <div class="row" style="font-family: 'Times New Roman', Times, serif;">
                <form:form modelAttribute="modelEdit" id="form-edit" class="form-horizontal">
                <div class="col-xs-12">

                        <div class="form-group">
                            <label class="col-xs-3">Ten toa nha</label>
                            <div class="col-xs-9">
                                <form:input path="name" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Quan</label>
                            <div class="col-xs-4">
                                <form:select path="district" class="form-control">
                                <form:option value="">--chon quan---</form:option>
                                <form:options items="${districtCode}"></form:options>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phuong</label>
                            <div class="col-xs-9">
                                <form:input path="ward" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Duong</label>
                            <div class="col-xs-9">
                                <form:input path="street" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Ket cau</label>
                            <div class="col-xs-9">
                                <form:input path="structure" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">So tang ham</label>
                            <div class="col-xs-9">
                                <form:input path="numberOfBasement" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Dien tich san</label>
                            <div class="col-xs-9">
                                <form:input path="floorArea" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Huong</label>
                            <div class="col-xs-9">
                                <form:input path="direction" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Hạng</label>
                            <div class="col-xs-9">
                                <form:input path="level" class="form-control"/>
                            </div>
                        </div>

                         <div class="form-group">
                            <label class="col-xs-3">Dien tich thue</label>
                            <div class="col-xs-9">
                                <form:input path="rentArea" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Gia thue</label>
                            <div class="col-xs-9">
                                <form:input path="rentPrice" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Mô tả giá</label>
                            <div class="col-xs-9">
                                <form:input path="rentPriceDescription" class="form-control"/>
                            </div>
                        </div>

                         <div class="form-group">
                            <label class="col-xs-3">Phí dịch vụ</label>
                            <div class="col-xs-9">
                                <form:input path="serviceFee" class="form-control"/>
                            </div>
                        </div>

                         <div class="form-group">
                            <label class="col-xs-3">Phí oto</label>
                            <div class="col-xs-9">
                                <form:input path="carFee" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí mô tô</label>
                            <div class="col-xs-9">
                                <form:input path="motoFee" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí ngoài giờ</label>
                            <div class="col-xs-9">
                                <form:input path="overtimeFee" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tiền điện</label>
                            <div class="col-xs-9">
                                <form:input path="electricityFee" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Đặt cọc</label>
                            <div class="col-xs-9">
                                <form:input path="deposit" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thanh toán</label>
                            <div class="col-xs-9">
                                <form:input path="payment" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Thời hạn thuê</label>
                            <div class="col-xs-9">
                                <form:input path="rentTime" class="form-control"/>
                            </div>
                        </div>

                         <div class="form-group">
                            <label class="col-xs-3">Thời gian trang trí</label>
                            <div class="col-xs-9">
                                <form:input path="decorationTime" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Tên quản lý</label>
                            <div class="col-xs-9">
                                <form:input path="managerName" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">SDT quản lý</label>
                            <div class="col-xs-9">
                                <form:input path="managerPhone" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Loai toa nha</label>
                            <div class="col-xs-9">
                                    <form:checkboxes path="typeCode" items="${typeCode}"/>
<%--                                <label>--%>
<%--                                    <input type="checkbox" id="typeCode" name="typeCode" value="nguyen-can">Nguyen can--%>
<%--                                </label>--%>

<%--                                <label>--%>
<%--                                    <input type="checkbox" id="typeCode" name="typeCode" value="tang-tret">Tang tret--%>
<%--                                </label>--%>

<%--                                <label>--%>
<%--                                    <input type="checkbox" id="typeCode" name="typeCode" value="noi-that">Noi that--%>
<%--                                </label>--%>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Phí môi giới</label>
                            <div class="col-xs-9">
                                <form:input path="brokerageFee" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-xs-3">Ghi chú</label>
                            <div class="col-xs-9">
                                <form:input path="note" class="form-control"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-xs-3"></label>
                            <div class="col-xs-9">
<%--                                <c:if test="${empty(building.id)}">--%>
<%--                                    <button class="btn btn-primary" id="btnAddBuilding" type="button" >Them toa nha</button>--%>
<%--                                </c:if>--%>
<%--                                --%>
<%--                                <c:if test="${not empty(building.id)}">--%>
<%--                                    <button class="btn btn-warning" id="btnAddBuilding" type="button" >Sua toa nha</button>--%>
<%--                                </c:if>--%>
                                <c:if test="${empty modelEdit.id}">
                                    <button class="btn btn-primary" id="btnAddBuilding" type="button" >Them toa nha</button>
                                </c:if>

                                <c:if test="${not empty modelEdit.id}">
                                    <button class="btn btn-warning" id="btnAddBuilding" type="button" >Sua toa nha</button>

                                </c:if>

                                <a href="/admin/building-list">
                                    <button class="btn btn-primary" id="" type="button" >huy thao tac</button>
                                </a>

                            </div>
                        </div>
                        <input type="hidden" name="id" value="${modelEdit.id}">

                </div>
                </form:form>
            </div>

        </div><!-- /.page-content -->
    </div>
</div><!-- /.main-content -->

<script>
    $("#btnAddBuilding").click(function(){
        var json = {};
        var typeCode = [];
        var formData = $('#form-edit').serializeArray();
        $.each(formData, function(i, it){
            if(it.name != 'typeCode')json["" + it.name + ""] = it.value;
            else typeCode.push(it.value);
        })
        json['typeCode'] = typeCode;
        if (json[name] == ''){
            return alert("Ten toa nha khong duoc thieu!");
        }else if(json['typeCode'] == ''){
            return alert("Loai toa nha khong duoc thieu!");
        }else {
            addOrUpdateBuilding(json);
        }
    });

    function addOrUpdateBuilding(data){
        $.ajax({
            type: "POST",
            url:"/api/buildings",
            data:JSON.stringify(data),//kieu du lieu ma client tra ve cho server
            dataType: "text",//kieu du lieu client mong muon server tra ra cho client
            contentType:"application/json",
            success : function(response){
                console.log("Success");
                alert(response);
                window.location.replace("/admin/building-list");
            },
            error : function(response){
                console.log("Failed");
                alert("Update Or Create Don't Success!");
            }
        });
    }
</script>
</body>
</html>
