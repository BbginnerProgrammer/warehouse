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
                                   value="<#if message??>${provider.name}</#if>" name="name" placeholder="Please fill provider" />
                            <#if textError??>
                                <div class="invalid-feedback">
                                    ${textError}
                                </div>
                            </#if>
                        </div>
                        <#--                        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Добавить</button>
                            <a href="/provider/cancel" class="btn btn-primary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>