<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" var="user"/>
    <security:authentication property="principal.authorities" var="role"/>

    <security:authorize access="hasRole('USER')" >

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ui/account/list">Show Accounts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/ui/customer/list">Show Customers</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
                <li class="nav-item" >

                    <h4  class=" text-success"> User name: ${user}  </h4>
                </li>  <li class="nav-item" >

                <h4  class=" text-success"> Role name: ${role}  </h4>
            </li>

            </ul>

        </nav>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')" >

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/getalluser">Show Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout</a>
                </li>
                <li class="nav-item" >

                    <h4  class=" text-success"> User name: ${user}  </h4>
                </li>  <li class="nav-item" >

                <h4  class=" text-success"> Role name: ${role}  </h4>
            </li>

            </ul>

        </nav>
    </security:authorize>

</security:authorize>
