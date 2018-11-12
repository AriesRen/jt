<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="logs" element-loading-text="Loading" border fit highlight-current-row>
      <el-table-column prop="id" label="ID" width="90" align="center"/>
      <el-table-column prop="username" label="用户名" align="center"/>
      <el-table-column prop="operation" label="操作" align="center"/>
      <el-table-column prop="method" label="方法" width="380" align="center"/>
      <el-table-column prop="params" label="参数" align="center"/>
      <el-table-column prop="time" label="执行时长" width="95" align="center"/>
      <el-table-column prop="ip" label="IP" width="120" align="center"/>
      <el-table-column prop="createdTime" label="createdTime" align="center">
        <template slot-scope="scope">
          {{ scope.row.createdTime }}
        </template>
      </el-table-column>
    </el-table>

    <div class="block">
      <el-pagination
        :total="row"
        :page-size="pageSize"
        :current-page="pageCurrent"
        :page-sizes="[5, 10, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"/>
    </div>
  </div>
</template>

<script>
import { getLogs } from '@/api/logs'

export default {
  data() {
    return {
      logs: null,
      pageCurrent: 1,
      pageCount: 0,
      row: 0,
      pageSize: 5,
      username: '',
      listLoading: true
    }
  },
  watch: {
    pageSize: function() {
      console.log('pageSize')
      this.fetchData()
    },
    pageCurrent: function() {
      console.log('pageCurrent')
      this.fetchData()
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getLogs(this.pageCurrent, this.pageSize, this.username).then(response => {
        console.log(response)
        this.logs = response.data.records
        this.pageCurrent = response.data.pageCurrent
        this.pageCount = response.data.pageCount
        this.pageSize = response.data.pageSize
        this.row = response.data.row
        this.listLoading = false
      })
    },

    handleSizeChange(val) {
      this.pageSize = val
    },
    handleCurrentChange(val) {
      this.pageCurrent = val
    }
  }
}
</script>

