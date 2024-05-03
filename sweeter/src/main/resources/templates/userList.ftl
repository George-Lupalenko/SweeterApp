<#import "parts/common.ftl" as c>

<@c.page>
    List of users
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a class="btn btn-dark" href="/user/${user.id}" role="button">Edit</a></td>
        </tr>
    </#list>
        </tbody>
    </table>

</@c.page>