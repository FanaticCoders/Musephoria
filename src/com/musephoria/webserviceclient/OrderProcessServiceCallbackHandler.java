
/**
 * OrderProcessServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */

    package com.musephoria.webserviceclient;

    /**
     *  OrderProcessServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class OrderProcessServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public OrderProcessServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public OrderProcessServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for confirmOrder method
            * override this method for handling normal response from confirmOrder operation
            */
           public void receiveResultconfirmOrder(
                    com.musephoria.webserviceclient.OrderProcessServiceStub.ConfirmOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from confirmOrder operation
           */
            public void receiveErrorconfirmOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createOrder method
            * override this method for handling normal response from createOrder operation
            */
           public void receiveResultcreateOrder(
                    com.musephoria.webserviceclient.OrderProcessServiceStub.CreateOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createOrder operation
           */
            public void receiveErrorcreateOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccount method
            * override this method for handling normal response from getAccount operation
            */
           public void receiveResultgetAccount(
                    com.musephoria.webserviceclient.OrderProcessServiceStub.GetAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccount operation
           */
            public void receiveErrorgetAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createAccount method
            * override this method for handling normal response from createAccount operation
            */
           public void receiveResultcreateAccount(
                    com.musephoria.webserviceclient.OrderProcessServiceStub.CreateAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createAccount operation
           */
            public void receiveErrorcreateAccount(java.lang.Exception e) {
            }
                


    }
    