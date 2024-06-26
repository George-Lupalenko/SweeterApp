<#import "parts/common.ftl" as c>

<@c.page>
    User editor

    <form action="/user" method="post" class="form-columns">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-dark mr-5" name="action" value="save">Save</button>
        <button type="submit" class="btn btn-dark mr-5" name="action" value="delete">Delete</button>
    </form>
    
</@c.page>