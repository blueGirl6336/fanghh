package hitwh.fanghh.pojo;

public class Dictionary {
    private Integer id;

    private Byte dictadminvisible;

    private String dictcode;

    private Integer dictdetailgroup;

    private String dictlogogram;

    private String dictmodulecode;

    private String dictname;

    private String dictparentcode;

    private Integer dictlevel;

    private String dictvalue;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getDictadminvisible() {
        return dictadminvisible;
    }

    public void setDictadminvisible(Byte dictadminvisible) {
        this.dictadminvisible = dictadminvisible;
    }

    public String getDictcode() {
        return dictcode;
    }

    public void setDictcode(String dictcode) {
        this.dictcode = dictcode == null ? null : dictcode.trim();
    }

    public Integer getDictdetailgroup() {
        return dictdetailgroup;
    }

    public void setDictdetailgroup(Integer dictdetailgroup) {
        this.dictdetailgroup = dictdetailgroup;
    }

    public String getDictlogogram() {
        return dictlogogram;
    }

    public void setDictlogogram(String dictlogogram) {
        this.dictlogogram = dictlogogram == null ? null : dictlogogram.trim();
    }

    public String getDictmodulecode() {
        return dictmodulecode;
    }

    public void setDictmodulecode(String dictmodulecode) {
        this.dictmodulecode = dictmodulecode == null ? null : dictmodulecode.trim();
    }

    public String getDictname() {
        return dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname == null ? null : dictname.trim();
    }

    public String getDictparentcode() {
        return dictparentcode;
    }

    public void setDictparentcode(String dictparentcode) {
        this.dictparentcode = dictparentcode == null ? null : dictparentcode.trim();
    }

    public Integer getDictlevel() {
        return dictlevel;
    }

    public void setDictlevel(Integer dictlevel) {
        this.dictlevel = dictlevel;
    }

    public String getDictvalue() {
        return dictvalue;
    }

    public void setDictvalue(String dictvalue) {
        this.dictvalue = dictvalue == null ? null : dictvalue.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}