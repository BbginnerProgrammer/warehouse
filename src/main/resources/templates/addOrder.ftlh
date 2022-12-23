<#import "path/common.ftlh" as c>

<@c.page>

    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class="text-center"> Add New Order </h1>
            <div class="card-body">
                <div class="form-group mt-3">
                    <form method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Продукт</label>
                            <select class="form-control" id="exampleFormControlSelect1" name="productName">
                                <#list productsName as name>
                                    <option value="${name.name}">${name.name}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlSelect1">Поставщик</label>
                            <div class="input-group">
                                <select class="form-control" id="exampleFormControlSelect1" name="provider">
                                    <#list providers as prov>
                                        <option value="${prov.name}">${prov.name}</option>
                                    </#list>
                                </select>
                                <div class="input-group-append">
                                    <a class="btn btn-success" type="button" href="/provider/add">+</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   value="<#if message??>${order.quantity}</#if>" name="quantity" placeholder="Please fill quantity">
                            <#if quantityError??>
                                <div class="invalid-feedback">
                                    ${quantityError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <input id="start" type="date" data-date-inline-picker="true" class="form-control"
                                   value="<#if message??>${order.date}</#if>" name="date" placeholder="Please fill date" min="${nowDate}">
                            <#if dateError??>
                                <div class="invalid-feedback">
                                    ${dateError}
                                </div>
                            </#if>
                        </div>
                        <#--                        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Добавить</button>
                            <a href="/orders/cancel" class="btn btn-primary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>