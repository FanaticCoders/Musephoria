

/**
 * ProductCatalogServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
    package com.musephoria.webserviceservice;

    /*
     *  ProductCatalogServiceTest Junit test case
    */

    public class ProductCatalogServiceTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testgetCategoryList() throws java.lang.Exception{

        com.musephoria.webserviceservice.ProductCatalogServiceStub stub =
                    new com.musephoria.webserviceservice.ProductCatalogServiceStub();//the default implementation should point to the right endpoint

           com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList getCategoryList12=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList.class);
                    // TODO : Fill in the getCategoryList12 here
                
                        assertNotNull(stub.getCategoryList(
                        getCategoryList12));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgetCategoryList() throws java.lang.Exception{
            com.musephoria.webserviceservice.ProductCatalogServiceStub stub = new com.musephoria.webserviceservice.ProductCatalogServiceStub();
             com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList getCategoryList12=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryList.class);
                    // TODO : Fill in the getCategoryList12 here
                

                stub.startgetCategoryList(
                         getCategoryList12,
                    new tempCallbackN65548()
                );
              


        }

        private class tempCallbackN65548  extends com.musephoria.webserviceservice.ProductCatalogServiceCallbackHandler{
            public tempCallbackN65548(){ super(null);}

            public void receiveResultgetCategoryList(
                         com.musephoria.webserviceservice.ProductCatalogServiceStub.GetCategoryListResponse result
                            ) {
                
            }

            public void receiveErrorgetCategoryList(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testgetProductInfo() throws java.lang.Exception{

        com.musephoria.webserviceservice.ProductCatalogServiceStub stub =
                    new com.musephoria.webserviceservice.ProductCatalogServiceStub();//the default implementation should point to the right endpoint

           com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo getProductInfo14=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo.class);
                    // TODO : Fill in the getProductInfo14 here
                
                        assertNotNull(stub.getProductInfo(
                        getProductInfo14));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgetProductInfo() throws java.lang.Exception{
            com.musephoria.webserviceservice.ProductCatalogServiceStub stub = new com.musephoria.webserviceservice.ProductCatalogServiceStub();
             com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo getProductInfo14=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfo.class);
                    // TODO : Fill in the getProductInfo14 here
                

                stub.startgetProductInfo(
                         getProductInfo14,
                    new tempCallbackN65604()
                );
              


        }

        private class tempCallbackN65604  extends com.musephoria.webserviceservice.ProductCatalogServiceCallbackHandler{
            public tempCallbackN65604(){ super(null);}

            public void receiveResultgetProductInfo(
                         com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductInfoResponse result
                            ) {
                
            }

            public void receiveErrorgetProductInfo(java.lang.Exception e) {
                fail();
            }

        }
      
        /**
         * Auto generated test method
         */
        public  void testgetProductList() throws java.lang.Exception{

        com.musephoria.webserviceservice.ProductCatalogServiceStub stub =
                    new com.musephoria.webserviceservice.ProductCatalogServiceStub();//the default implementation should point to the right endpoint

           com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList getProductList16=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList.class);
                    // TODO : Fill in the getProductList16 here
                
                        assertNotNull(stub.getProductList(
                        getProductList16));
                  



        }
        
         /**
         * Auto generated test method
         */
        public  void testStartgetProductList() throws java.lang.Exception{
            com.musephoria.webserviceservice.ProductCatalogServiceStub stub = new com.musephoria.webserviceservice.ProductCatalogServiceStub();
             com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList getProductList16=
                                                        (com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList)getTestObject(com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductList.class);
                    // TODO : Fill in the getProductList16 here
                

                stub.startgetProductList(
                         getProductList16,
                    new tempCallbackN65660()
                );
              


        }

        private class tempCallbackN65660  extends com.musephoria.webserviceservice.ProductCatalogServiceCallbackHandler{
            public tempCallbackN65660(){ super(null);}

            public void receiveResultgetProductList(
                         com.musephoria.webserviceservice.ProductCatalogServiceStub.GetProductListResponse result
                            ) {
                
            }

            public void receiveErrorgetProductList(java.lang.Exception e) {
                fail();
            }

        }
      
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

    }
    