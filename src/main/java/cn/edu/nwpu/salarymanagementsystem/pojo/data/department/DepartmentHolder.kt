package cn.edu.nwpu.salarymanagementsystem.pojo.data.department

/**
 * 统一管理所有部门信息。
 *
 * @author UnscientificJsZhai
 */
object DepartmentHolder {

    private val map = HashMap<String, MutableDepartment>()

    /**
     * 获取部门信息。
     *
     * @return 部门信息。如果尚未实例化则从数据库中查询并实例化。如果数据库中无记录则返回null。
     */
    fun getDepartment(name: String): MutableDepartment? {
        return this.map[name] ?: queryDepartmentFromDatabase(name)
    }

    /**
     * 从数据库中查询部门信息。
     *
     * @return 部门信息。如果数据库中无记录则返回null。
     */
    private fun queryDepartmentFromDatabase(name: String): MutableDepartment? {
        //TODO 从数据库查询
        return null
    }

    @Synchronized
    fun updateDepartment(oldName: String, department: MutableDepartment) {
        this.map.remove(oldName)
        this.map[department.name] = department
    }
}