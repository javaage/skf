package com.skf.management.model;

public class NodeModelWithBLOBs extends NodeModel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Node.NodeName
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    private String nodename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dbo.Node.NodeDescription
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    private String nodedescription;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Node.NodeName
     *
     * @return the value of dbo.Node.NodeName
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    public String getNodename() {
        return nodename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Node.NodeName
     *
     * @param nodename the value for dbo.Node.NodeName
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dbo.Node.NodeDescription
     *
     * @return the value of dbo.Node.NodeDescription
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    public String getNodedescription() {
        return nodedescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dbo.Node.NodeDescription
     *
     * @param nodedescription the value for dbo.Node.NodeDescription
     *
     * @mbg.generated Tue Jun 05 10:28:23 CST 2018
     */
    public void setNodedescription(String nodedescription) {
        this.nodedescription = nodedescription;
    }
}