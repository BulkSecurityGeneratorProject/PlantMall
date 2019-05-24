package com.ybb.mall.web.rest.controller.wx;

import com.codahale.metrics.annotation.Timed;
import com.ybb.mall.service.wx.WXOrderService;
import com.ybb.mall.web.rest.controller.wx.vm.order.SubmitAppointmentOrderVM;
import com.ybb.mall.web.rest.controller.wx.vm.order.SubmitOrderVM;
import com.ybb.mall.web.rest.util.ResultObj;
import com.ybb.mall.web.rest.vm.order.OrderVM;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

/**
 * @Description : 微信小程序-订单管理
 * @Author 黄志成
 * @Date 2019-05-21
 * @Version
 */

@Api(description = "微信小程序-订单管理")
@RestController
@RequestMapping("/mall/wx")
public class WXOrderController {

    private final WXOrderService wxOrderService;

    public WXOrderController(WXOrderService wxOrderService) {
        this.wxOrderService = wxOrderService;
    }


    /**
     * 提交订单
     */
    @ApiOperation("提交订单")
    @PostMapping("/order")
    @Timed
    public ResultObj createOrder(@RequestBody SubmitOrderVM submitOrder) throws URISyntaxException {
        return wxOrderService.insertOrder(submitOrder);
    }

    /**
     * 查询用户订单列表
     */
    @ApiOperation("查询用户订单列表")
    @GetMapping("/order")
    @Timed
    public ResultObj selectOrderList(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam Long userId,
                                     @ApiParam(name = "status", value = "订单状态", required = true) @RequestParam Integer status,
                                     @ApiParam(name = "pageNum", value = "页码", required = true) @RequestParam Integer pageNum,
                                     @ApiParam(name = "pageSize", value = "数量", required = true) @RequestParam Integer pageSize) throws URISyntaxException {
        return wxOrderService.findOrderListByUserId(userId, status, pageNum, pageSize);
    }

    /**
     * 查询用户租赁订单绿植养护列表
     */
    @ApiOperation("查询用户订单列表")
    @GetMapping("/order/service")
    @Timed
    public ResultObj selectOrderServiceList(@ApiParam(name = "userId", value = "用户id", required = true) @RequestParam Long userId,
                                            @ApiParam(name = "pageNum", value = "页码", required = true) @RequestParam Integer pageNum,
                                            @ApiParam(name = "pageSize", value = "数量", required = true) @RequestParam Integer pageSize) throws URISyntaxException {
        return wxOrderService.findOrderServiceListByUserId(userId, pageNum, pageSize);
    }

    /**
     * 查询某一租赁订单养护计划
     */
    @ApiOperation("查询某一租赁订单养护计划")
    @GetMapping("/order/maintenance")
    @Timed
    public ResultObj findMaintenanceByOrderId(@ApiParam(name = "id", value = "订单id", required = true) @RequestParam Long id) throws URISyntaxException {
        return wxOrderService.findMaintenanceByOrderId(id);
    }

    /**
     * 确认收货
     */
    @ApiOperation("确认收货")
    @PutMapping("/order")
    @Timed
    public ResultObj confirmReceive(@RequestBody OrderVM orderVM) throws URISyntaxException {
        return wxOrderService.updateOrderStatusById(orderVM.getId());
    }

    /**
     * 删除订单
     */
    @ApiOperation("删除订单")
    @DeleteMapping("/order")
    @Timed
    public ResultObj deleteOrder(@ApiParam(name = "id", value = "订单id", required = true) @RequestParam Long id) throws URISyntaxException {
        return null;
    }

    /**
     * 提交预约订单
     */
    @ApiOperation("提交预约订单")
    @PostMapping("/appointment")
    @Timed
    public ResultObj createAppointmentOrder(@RequestBody SubmitAppointmentOrderVM submitAppointmentOrder) throws URISyntaxException {
        return wxOrderService.insertAppointmentOrder(submitAppointmentOrder);
    }
}