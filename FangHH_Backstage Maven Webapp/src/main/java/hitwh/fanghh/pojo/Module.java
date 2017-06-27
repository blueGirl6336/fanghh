package hitwh.fanghh.pojo;

public class Module {
    private Integer id;

    private String moduleCode;

    private Byte hasPage;

    private String iconUrl;

    private Integer moduleLevel;

    private String moduleName;

    private String parentCode;

    private String path;

    private String url;

    private String remark;

    private Integer moduleDetailgroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    public Byte getHasPage() {
        return hasPage;
    }

    public void setHasPage(Byte hasPage) {
        this.hasPage = hasPage;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Integer getModuleLevel() {
        return moduleLevel;
    }

    public void setModuleLevel(Integer moduleLevel) {
        this.moduleLevel = moduleLevel;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getModuleDetailgroup() {
        return moduleDetailgroup;
    }

    public void setModuleDetailgroup(Integer moduleDetailgroup) {
        this.moduleDetailgroup = moduleDetailgroup;
    }
}