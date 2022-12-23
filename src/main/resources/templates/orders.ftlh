<#import "path/common.ftlh" as c>

<@c.page>
    <div class="container mt-4 pt-3 pb-3 rounded" style="background: #efefef" >
        <a class="btn btn-success" type="button" href="/orders/add">+Добавить</a>

    </div>
    <div class="row pt-3 pl-3">
        <table class="table">
            <caption>Список продуктов</caption>
            <thead>
            <tr class="table" style="background: #efefef">
                <th scope="col">Код продукта</th>
                <th scope="col">Продук</th>
                <th scope="col">Поставщик</th>
                <th scope="col">Количество</th>
                <th scope="col">дата поступления</th>
            </tr>
            </thead>
            <tbody>
            <#list orders as order>
                <tr>
                    <td>${order?index + 1}</td>
                    <td>${order.productName}</td>
                    <td>${order.provider}</td>
                    <td>${order.quantity}</td>
                    <td>${order.date}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>