<#import "path/common.ftlh" as c>

<@c.page>
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class="text-center"> Create New Student </h1>
            <div class="card-body">
                <div class="form-group mt-3">
                    <form method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                                   value="<#if message??>${product.name}</#if>" name="name" placeholder="Please fill Name" />
                            <#if textError??>
                                <div class="invalid-feedback">
                                    ${textError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   value="<#if message??>${product.brand}</#if>" name="brand" placeholder="Please fill brand">
                            <#if brandError??>
                                <div class="invalid-feedback">
                                    ${brandError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   value="<#if message??>${product.description}</#if>" name="description" placeholder="Please fill description">
                            <#if descriptionError??>
                                <div class="invalid-feedback">
                                    ${descriptionError}
                                </div>
                            </#if>
                        </div>
<#--                        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Добавить</button>
                            <a href="/product/cancel" class="btn btn-primary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>