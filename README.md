# Como fazer a autenticdação


## faça um request para registrar um user

http://localhost:8080/RestAPIFurb/auth/sign-up

{
        "nomeUsuario": "fulano",
        "telefoneUsuario": "99999999",
        "senha":"senha",
        "login":"login"
}

## Faça um login com o user criado

 (url padrão do spring boot para login)

 http://localhost:8080/login   
 

{
        "senha":"senha",
        "login":"login"
 }
 
 ## Coloque o token JWT gerado no header dos requests
 
 um token muito similar a este:
 
 Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJiYXRhdGEiLCJleHAiOjE2MTQyOTQ0MDF9.7kHuSCRDUJmFKyoueEX8mGFbpR008y6sZO47-5rfYZFym7mu35jheVIUz0oyGQuCHOQ6BLJmQOTwX47wAOPQNw
 
 estará no Header "Authorization" do RESPONSE do login, caso bem sucedido.
 
 ## Use o JWT para fazer requests
 
 Cole o recem gerado jwt no Header "Authorization" do REQUEST 
 
 Pronto! Agora você tem acesso a aplicação!
 
