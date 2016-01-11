package com.notrace.bottomtab.Api;

import com.notrace.bottomtab.entitys.Res_Product;

import retrofit.http.Field;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by notrace on 2015/12/29.
 */
public interface ProductApi {
    @POST("product/findProductLists")
    Observable<Res_Product>getProductList(@Field("positionId") String positinId);
}
