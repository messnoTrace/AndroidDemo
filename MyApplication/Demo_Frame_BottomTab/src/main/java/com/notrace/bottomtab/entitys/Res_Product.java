package com.notrace.bottomtab.entitys;

import java.io.Serializable;
import java.util.List;

/**
 * Created by notrace on 2015/12/29.
 */
public class Res_Product {
    private List<Product> data;

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public class Product implements Serializable {

        private String id;
        private String distributorCode;
        private String productCode;
        private String productName;
        private String productCatId;
        private String productCatCode;
        private String productType;
        private String productPicture;
        private String unit;
        private String period;
        private String weekRate;
        private String standardProfit;
        private String maxProfit;
        private String minInvest;
        private String maxInvest;
        private String raiseInvest;
        private String defaultExpireProcessMode;
        private String defaultInterestCalculation;
        private String sellStatus;
        private String publishStatus;
        private String createTime;
        private String creator;
        private String accrualDays;
        private String isThird;
        private String isNaturalDay;
        private String productDesc;
        private String faq;
        private String auditStatus;
        private String auditResult;
        private String auditTime;
        private String auditer;
        private String remark;
        private String syncTime;
        private String continuedInvestmentStatus;
        private String rate;
        private String publishId;
        private String publishCode;
        private String publishName;
        private String expandProfit;
        private String marketProfit;
        private String amount;
        private String seld;
        private String remaining;
        private String riskLevel;
        private String terminalType;
        private String displayOrder;
        private String discountWay;
        private String isDistribute;
        private String tagName;
        private String icon;



        private String startAccrualDate;//起息时间
        private String endAccrualDate;//结息时间
        private String terminalProfit;//终端收益
        private  String purchaserProfit;//新老用户收益
        private String purchaserType;//用户类型
        private String distributionProfit;//分销收益

        public String getStartAccrualDate() {
            return startAccrualDate;
        }

        public void setStartAccrualDate(String startAccrualDate) {
            this.startAccrualDate = startAccrualDate;
        }

        public String getEndAccrualDate() {
            return endAccrualDate;
        }

        public void setEndAccrualDate(String endAccrualDate) {
            this.endAccrualDate = endAccrualDate;
        }

        public String getTerminalProfit() {
            return terminalProfit;
        }

        public void setTerminalProfit(String terminalProfit) {
            this.terminalProfit = terminalProfit;
        }

        public String getPurchaserProfit() {
            return purchaserProfit;
        }

        public void setPurchaserProfit(String purchaserProfit) {
            this.purchaserProfit = purchaserProfit;
        }

        public String getPurchaserType() {
            return purchaserType;
        }

        public void setPurchaserType(String purchaserType) {
            this.purchaserType = purchaserType;
        }

        public String getDistributionProfit() {
            return distributionProfit;
        }

        public void setDistributionProfit(String distributionProfit) {
            this.distributionProfit = distributionProfit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDistributorCode() {
            return distributorCode;
        }

        public void setDistributorCode(String distributorCode) {
            this.distributorCode = distributorCode;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductCatId() {
            return productCatId;
        }

        public void setProductCatId(String productCatId) {
            this.productCatId = productCatId;
        }

        public String getProductCatCode() {
            return productCatCode;
        }

        public void setProductCatCode(String productCatCode) {
            this.productCatCode = productCatCode;
        }

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getProductPicture() {
            return productPicture;
        }

        public void setProductPicture(String productPicture) {
            this.productPicture = productPicture;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getWeekRate() {
            return weekRate;
        }

        public void setWeekRate(String weekRate) {
            this.weekRate = weekRate;
        }

        public String getStandardProfit() {
            return standardProfit;
        }

        public void setStandardProfit(String standardProfit) {
            this.standardProfit = standardProfit;
        }

        public String getMaxProfit() {
            return maxProfit;
        }

        public void setMaxProfit(String maxProfit) {
            this.maxProfit = maxProfit;
        }

        public String getMinInvest() {
            return minInvest;
        }

        public void setMinInvest(String minInvest) {
            this.minInvest = minInvest;
        }

        public String getMaxInvest() {
            return maxInvest;
        }

        public void setMaxInvest(String maxInvest) {
            this.maxInvest = maxInvest;
        }

        public String getRaiseInvest() {
            return raiseInvest;
        }

        public void setRaiseInvest(String raiseInvest) {
            this.raiseInvest = raiseInvest;
        }

        public String getDefaultExpireProcessMode() {
            return defaultExpireProcessMode;
        }

        public void setDefaultExpireProcessMode(String defaultExpireProcessMode) {
            this.defaultExpireProcessMode = defaultExpireProcessMode;
        }

        public String getDefaultInterestCalculation() {
            return defaultInterestCalculation;
        }

        public void setDefaultInterestCalculation(String defaultInterestCalculation) {
            this.defaultInterestCalculation = defaultInterestCalculation;
        }

        public String getSellStatus() {
            return sellStatus;
        }

        public void setSellStatus(String sellStatus) {
            this.sellStatus = sellStatus;
        }

        public String getPublishStatus() {
            return publishStatus;
        }

        public void setPublishStatus(String publishStatus) {
            this.publishStatus = publishStatus;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getAccrualDays() {
            return accrualDays;
        }

        public void setAccrualDays(String accrualDays) {
            this.accrualDays = accrualDays;
        }

        public String getIsThird() {
            return isThird;
        }

        public void setIsThird(String isThird) {
            this.isThird = isThird;
        }

        public String getIsNaturalDay() {
            return isNaturalDay;
        }

        public void setIsNaturalDay(String isNaturalDay) {
            this.isNaturalDay = isNaturalDay;
        }

        public String getProductDesc() {
            return productDesc;
        }

        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }

        public String getFaq() {
            return faq;
        }

        public void setFaq(String faq) {
            this.faq = faq;
        }

        public String getAuditStatus() {
            return auditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            this.auditStatus = auditStatus;
        }

        public String getAuditResult() {
            return auditResult;
        }

        public void setAuditResult(String auditResult) {
            this.auditResult = auditResult;
        }

        public String getAuditTime() {
            return auditTime;
        }

        public void setAuditTime(String auditTime) {
            this.auditTime = auditTime;
        }

        public String getAuditer() {
            return auditer;
        }

        public void setAuditer(String auditer) {
            this.auditer = auditer;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSyncTime() {
            return syncTime;
        }

        public void setSyncTime(String syncTime) {
            this.syncTime = syncTime;
        }

        public String getContinuedInvestmentStatus() {
            return continuedInvestmentStatus;
        }

        public void setContinuedInvestmentStatus(String continuedInvestmentStatus) {
            this.continuedInvestmentStatus = continuedInvestmentStatus;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getPublishId() {
            return publishId;
        }

        public void setPublishId(String publishId) {
            this.publishId = publishId;
        }

        public String getPublishCode() {
            return publishCode;
        }

        public void setPublishCode(String publishCode) {
            this.publishCode = publishCode;
        }

        public String getPublishName() {
            return publishName;
        }

        public void setPublishName(String publishName) {
            this.publishName = publishName;
        }

        public String getExpandProfit() {
            return expandProfit;
        }

        public void setExpandProfit(String expandProfit) {
            this.expandProfit = expandProfit;
        }

        public String getMarketProfit() {
            return marketProfit;
        }

        public void setMarketProfit(String marketProfit) {
            this.marketProfit = marketProfit;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getSeld() {
            return seld;
        }

        public void setSeld(String seld) {
            this.seld = seld;
        }

        public String getRemaining() {
            return remaining;
        }

        public void setRemaining(String remaining) {
            this.remaining = remaining;
        }

        public String getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
        }

        public String getTerminalType() {
            return terminalType;
        }

        public void setTerminalType(String terminalType) {
            this.terminalType = terminalType;
        }

        public String getDisplayOrder() {
            return displayOrder;
        }

        public void setDisplayOrder(String displayOrder) {
            this.displayOrder = displayOrder;
        }

        public String getDiscountWay() {
            return discountWay;
        }

        public void setDiscountWay(String discountWay) {
            this.discountWay = discountWay;
        }

        public String getIsDistribute() {
            return isDistribute;
        }

        public void setIsDistribute(String isDistribute) {
            this.isDistribute = isDistribute;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }


}
