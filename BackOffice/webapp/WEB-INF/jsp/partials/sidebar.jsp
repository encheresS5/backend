<%--
  Created by IntelliJ IDEA.
  User: tsiry
  Date: 11/10/2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link " href="index.html">
                <i class="bi bi-grid"></i>
                <span>Dashboard</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#candidat-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-person-square"></i><span>Candidats</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="candidat-nav" class="nav-content collapse " data-bs-parent="#candidat-nav">
                <li>
                    <a href="insertion">
                        <i class="bi bi-circle"></i><span>Insérer un nouveau candidat</span>
                    </a>
                </li>
                <li>
                    <a href="personal_data">
                        <i class="bi bi-circle"></i><span>Voir la liste des candidats</span>
                    </a>
                </li>
                <li>
                    <a href="admission_choix?action=admission">
                        <i class="bi bi-circle"></i><span>Accepter des candidatures</span>
                    </a>
                </li>
                <li>
                    <a href="admission_choix?action=inscription">
                        <i class="bi bi-circle"></i><span>Valider inscription</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#etudiant-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-person-square"></i><span>Etudiants</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="etudiant-nav" class="nav-content collapse " data-bs-parent="#candidat-nav">
                <li>
                    <a href="choix_ecolage">
                        <i class="bi bi-circle"></i><span>Payer l'écolage</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-error-404.html">
                <i class="bi bi-dash-circle"></i>
                <span>Error 404</span>
            </a>
        </li><!-- End Error 404 Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="pages-blank.html">
                <i class="bi bi-file-earmark"></i>
                <span>Blank</span>
            </a>
        </li><!-- End Blank Page Nav -->

    </ul>

</aside>