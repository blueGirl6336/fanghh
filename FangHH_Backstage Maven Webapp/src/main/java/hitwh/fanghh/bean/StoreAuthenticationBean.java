package hitwh.fanghh.bean;

public class StoreAuthenticationBean
{
	private Integer storeId;// id
	private String storeName;// 门店名称
	private String status;// 状态
	private String failedReason;// 审核失败原因
	private String businessLicensePhoto;// 营业执照照片URL，只有一张照片

	public Integer getStoreId()
	{
		return storeId;
	}

	public void setStoreId(Integer storeId)
	{
		this.storeId = storeId;
	}

	public String getStoreName()
	{
		return storeName;
	}

	public void setStoreName(String storeName)
	{
		this.storeName = storeName;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getFailedReason()
	{
		return failedReason;
	}

	public void setFailedReason(String failedReason)
	{
		this.failedReason = failedReason;
	}

	public String getBusinessLicensePhoto()
	{
		return businessLicensePhoto;
	}

	public void setBusinessLicensePhoto(String businessLicensePhoto)
	{
		this.businessLicensePhoto = businessLicensePhoto;
	}
}
