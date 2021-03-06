package com.lnet.tms.rest.spi;


import com.lnet.tms.model.dispatch.DispatchAssign;
import com.lnet.tms.model.otd.OtdCarrierOrder;
import com.lnet.tms.model.otd.OtdCarrierOrderBean;
import com.lnet.tms.model.otd.OtdOrderSign;
import com.lnet.tms.model.otd.OtdTransportOrder;
import com.lnet.tms.rest.restUtil.*;

import javax.ws.rs.*;
import java.util.UUID;

/**
 * Created by admin on 2015/7/10.
 */
@Path(value = "/order")
@Produces({"application/json"})
public interface OrderResource {

    @GET
    @Path("/transportOrder/{orderNumber}")
    ServiceResult getTransportOrderByNumber(@PathParam("orderNumber")String orderNumber);

    //查找客户是否有此单号
    @POST
    @Path("/getTransportOrderByClient")
    @Consumes({"application/json"})
    ServiceResult getTransportOrderByClient(OrderRequest orderRequest);

    //查找承运商是否有此单号
    @POST
    @Path("/getCarrierOrderByCarrier")
    @Consumes({"application/json"})
    ServiceResult getCarrierOrderByCarrier(OrderRequest orderRequest);

    @GET
    @Path("/getTransportOrderByCarrierOrder/{orderNumber}")
    ServiceResult getTransportOrderByCarrierOrder(@PathParam("orderNumber")String orderNumber);

    @GET
    @Path("/getTransportOrderById/{orderId}")
    ServiceResult getTransportOrderById(@PathParam("orderId")UUID orderId);

    @GET
    @Path("/carrierOrder/{orderNumber}")
    ServiceResult getCarrierOrderByNumber(@PathParam("orderNumber")String orderNumber);

    @GET
    @Path("/getCarrierOrderById/{orderId}")
    ServiceResult getCarrierOrderById(@PathParam("orderId")UUID orderId);

    @POST
    @Path(value = "/transportOrderListByNumber")
    @Consumes({"application/json"})
    ServiceResult transportOrderListByNumber(OrderListRequest request);

    @GET
    @Path(value = "/transportOrderList/{userId}")
    ServiceResult getTransportOrderList(@PathParam("userId")UUID userId);


    @POST
    @Path(value = "/carrierOrderListByNumber")
    @Consumes({"application/json"})
    ServiceResult carrierOrderListByNumber(OrderListRequest request);

    @GET
    @Path(value = "/carrierOrderList/{userId}")
    ServiceResult getCarrierOrderList(@PathParam("userId")UUID userId);

    @POST
    @Path(value = "/transportOrderCreate")
    @Consumes({"application/json"})
    ServiceResult transportOrderCreate(OtdTransportOrder otdTransportOrder);

    @POST
    @Path(value = "/carrierOrderCreate")
    @Consumes({"application/json"})
    ServiceResult carrierOrderCreate(OtdCarrierOrderBean otdCarrierOrder);

    @POST
    @Path("/calculate")
    @Consumes({"application/json"})
    ServiceResult calculate(OtdCarrierOrder otdCarrierOrder);

    @POST
    @Path("/updatePayable/{orderPayableId}")
    @Consumes({"application/json"})
    ServiceResult updatePayable(@PathParam("orderPayableId")UUID orderPayableId,FeeOrderPayables payableList);

    @GET
    @Path("/getSupperBaseRegion")
    ServiceResult getSupperBaseRegion();

    @GET
    @Path("/getChildBaseRegion/{superRegionId}")
    ServiceResult getChildBaseRegion(@PathParam("superRegionId")UUID superRegionId);

    @GET
    @Path("/getOrganization")
    ServiceResult getOrganization();

    @POST
    @Path("/feeDeclare")
    @Consumes({"application/json"})
    ServiceResult createFeeDeclare(FeeDeclare feeDeclare);

    @GET
    @Path("/getCars")
    ServiceResult getCars();

    @POST
    @Path("/createDispatchAssign")
    @Consumes({"application/json"})
    ServiceResult createDispatchAssign(DispatchAssign assign);

    @GET
    @Path("/getDispatchAssignList/{userId}")
    ServiceResult getDispatchAssignList(@PathParam("userId")UUID userId);

    @POST
    @Path("/getDispatchAssignListByNumber")
    ServiceResult getDispatchAssignListByNumber(OrderListRequest request);

    @GET
    @Path("/getDispatchAssignById/{assignById}")
    ServiceResult getDispatchAssignById(@PathParam("assignById")UUID assignById);

    /**
     * 订单签收*/
    @POST
    @Path("/orderSignUp")
    @Consumes({"application/json"})
    ServiceResult orderSignUp(AppOrderSign appOrderSign);

}
