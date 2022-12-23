<#import "path/common.ftlh" as c>

<@c.page>

    <div class="container mt-4 pt-3 pb-3 rounded" style="background: #efefef" >
        <a class="btn btn-success" type="button" href="/product/add">+Добавить</a>

    </div>
    <div class="row pt-3 pl-3">
        <table class="table">
            <caption>Список продуктов</caption>
            <thead>
            <tr class="table" style="background: #efefef">
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Описание</th>
                <th scope="col">Бредн</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <#list products as product>
            <tr>
                <td>${product?index + 1}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.brand}</td>
                <td>
                    <a class="btn btn-primary" href="/product/edit/${product.id}">update</a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>

</@c.page>