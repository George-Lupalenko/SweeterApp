<#import "parts/common.ftl" as c>
<#import "parts/loginForm.ftl" as l>

<@c.page>
    Add new user
    ${message?if_exists}
    <@l.login "/registration" true />
</@c.page>
