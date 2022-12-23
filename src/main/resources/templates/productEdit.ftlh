<#import "path/common.ftlh" as c>

<@c.page>
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class="text-center"> Create New Student </h1>
            <div class="card-body">
                <div class="form-group mt-3">
                    <form action="/product/edit/${product.id}" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                                   value="${product.name}" name="name" placeholder="Please fill Name" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   value="${product.description}" name="description" placeholder="Please fill description">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control"
                                   value="${product.brand}" name="brand" placeholder="Please fill brand">
                        </div>
                        <#--                        <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
                        <input type="hidden" value="${product.id}" name="productId">
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>