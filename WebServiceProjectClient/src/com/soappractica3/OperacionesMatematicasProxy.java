package com.soappractica3;

public class OperacionesMatematicasProxy implements com.soappractica3.OperacionesMatematicas {
  private String _endpoint = null;
  private com.soappractica3.OperacionesMatematicas operacionesMatematicas = null;
  
  public OperacionesMatematicasProxy() {
    _initOperacionesMatematicasProxy();
  }
  
  public OperacionesMatematicasProxy(String endpoint) {
    _endpoint = endpoint;
    _initOperacionesMatematicasProxy();
  }
  
  private void _initOperacionesMatematicasProxy() {
    try {
      operacionesMatematicas = (new com.soappractica3.OperacionesMatematicasServiceLocator()).getOperacionesMatematicas();
      if (operacionesMatematicas != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)operacionesMatematicas)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)operacionesMatematicas)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (operacionesMatematicas != null)
      ((javax.xml.rpc.Stub)operacionesMatematicas)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.soappractica3.OperacionesMatematicas getOperacionesMatematicas() {
    if (operacionesMatematicas == null)
      _initOperacionesMatematicasProxy();
    return operacionesMatematicas;
  }
  
  public int sumarNumeros(int a, int b) throws java.rmi.RemoteException{
    if (operacionesMatematicas == null)
      _initOperacionesMatematicasProxy();
    return operacionesMatematicas.sumarNumeros(a, b);
  }
  
  
}