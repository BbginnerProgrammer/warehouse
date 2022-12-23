<#import "path/common.ftlh" as c>

<@c.page>

    <form method="post" enctype="multipart/form-data">
    <div class="container mt-4 pt-3 pb-3 rounded" style="background: #efefef" >
        <input id="start" type="date" data-date-inline-picker="true" class="form-control"
               name="start" placeholder="Please fill date" min="${nowDate}">
        <button type="submit" class="btn btn-primary">Добавить</button>
    </div>
    </form>
    <div class="row pt-3 pl-3">
        <table class="table">
            <caption>Список продуктов</caption>
            <thead>
            <tr class="table" style="background: #efefef">
                <th scope="col">#</th>
                <th scope="col">Название</th>
                <th scope="col">Запас</th>
            </tr>
            </thead>
            <tbody>
            <#list stocks as stock>
                <tr>
                    <td>${stock?index + 1}</td>
                    <td>${stock.name}</td>
                    <td>${stock.quantity}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>