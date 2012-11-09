/**
 *  
 * @return Object literal singleton instance of DirectoryListing
 */
var TesteJSplugin = function() {};

/**
  * @param inputParams Input parameters
  * @param successCallback The callback which will be called when directory listing is successful
  * @param failureCallback The callback which will be called when directory listing encouters an error
  */
TesteJSplugin.prototype.generateTesteJSPlugin = 
    function(inputParams,successCallback, failureCallback)
    {
        // Chama (função Sucesso, função Falha, nome plugin-xml, ação, parâmetros de entrada)
        return PhoneGap.exec( successCallback, failureCallback, 'TestePlugin','add', inputParams);
    };
// Adiciona ao construtor do PhoneGap este JS de chamada do plugin
// 'testeJSplugin' serah chamado no .html como: window.plugins.testeJSplugin   
PhoneGap.addConstructor(    function() {PhoneGap.addPlugin("testeJSplugin", new TesteJSplugin());}  );