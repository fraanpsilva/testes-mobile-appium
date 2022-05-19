# Testes Mobile - Android - com Appium
### Como o Appium funciona
* primeiro instalamos o Appium Server - esse server que faz a comunicação com o dispositivo **(Android, chrome, IOS)**
  * Instalação via npm
    * > npm install -g appium
  * Em seguida verifica a instalação com appium-doctor
    * > npm install -g appium-doctor
    * Para verificar se todas as dependências estão configuradas corretamente execute 
      * > appium-doctor
  
* Em seguida criamos o projeto com Java (nesse caso) e usamos o **Java-client** do Appium
  * pois é ele que envia as requisições para o servidor, e o servidor executa essas requisiçoes no aplicativo
  * Há O Client Appium para
    * Javascript
    * C#
    * Ruby
    * Python, etc