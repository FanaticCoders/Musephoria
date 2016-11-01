
/**
 * ProductCatalogServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

    package com.musephoria.webserviceclient;

    /**
     *  ProductCatalogServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ProductCatalogServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ProductCatalogServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ProductCatalogServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCategoryList method
            * override this method for handling normal response from getCategoryList operation
            */
           public void receiveResultgetCategoryList(
                    com.musephoria.webserviceclient.ProductCatalogServiceStub.GetCategoryListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCategoryList operation
           */
            public void receiveErrorgetCategoryList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProductInfo method
            * override this method for handling normal response from getProductInfo operation
            */
           public void receiveResultgetProductInfo(
                    com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProductInfo operation
           */
            public void receiveErrorgetProductInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProductList method
            * override this method for handling normal response from getProductList operation
            */
           public void receiveResultgetProductList(
                    com.musephoria.webserviceclient.ProductCatalogServiceStub.GetProductListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProductList operation
           */
            public void receiveErrorgetProductList(java.lang.Exception e) {
            }
                


    }
    