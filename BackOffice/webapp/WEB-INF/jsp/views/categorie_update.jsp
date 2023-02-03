<%@ page import="encheres.backoffice.models.Categorie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Categorie categorie = (Categorie) request.getAttribute("categorie");
%>

<main id="main" class="main">
    <div class="pagetitle">
        <h1>Modifier Categorie</h1>
    </div>

    <section class="section">
        <div class="row">
            <div class="col col-lg-6">
                <div class="card">
                    <div class="card-body">
                        <h1 class="card-title">Modification</h1>
                        <form>
                            <label for="libelle">Libellé</label>
                            <input id="libelle" class="form-control" name="libelle" type="text" value="<% out.print(categorie.getLibelle()); %>">
                            <br>
                            <input class="form-control btn-primary" type="submit" value="Modifier" onclick="put()">
                            <hr>
                            <a class="btn btn-danger form-control" onclick="del()">Supprimer categorie</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<script>
    const id = "<% out.print(categorie.getIdCategorie()); %>";
    async function put() {
        await fetch("http://localhost:1234/categories/"+ id ,{
            method:"PUT",
        })
            .then(data=> {
                console.log(data);
                window.location.href = "http://localhost:1234/categories"
            })
            .catch(err=>console.log(err));
    }

    async function del() {
        await fetch("http://localhost:1234/categories/"+ id ,{
            method:"DELETE",
        })
            .then(data=> {
                console.log(data);
                window.location.href = "http://localhost:1234/categories"
            })
            .catch(err=>console.log(err));
    }
</script>