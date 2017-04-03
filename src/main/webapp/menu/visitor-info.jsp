<%@ page language="java" pageEncoding="UTF-8" %>
<style type="text/css">
#accordion .panel-heading {
	cursor: pointer;
}
#accordion .panel-body {
	padding:0px;
}
</style>

      <!-- start of sidebar -->
<div class="panel-group col-md-2" id="accordion" role="tablist" aria-multiselectable="true" >

  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="collapse-header-visitor" data-toggle="collapse" data-parent="#accordion" href="#collapse-body-visitor" aria-expanded="true" aria-controls="collapse-body-visitor">
      <h4 class="panel-title">
	    <i class="glyphicon glyphicon-list"></i>
        访客管理
      </h4>
    </div>
    <div id="collapse-body-visitor" class="panel-collapse collapse ${currentMenu == 'visitor' ? 'in' : ''}" role="tabpanel" aria-labelledby="collapse-header-visitor">
      <div class="panel-body">
        <ul class="nav nav-list">
		  <li><a href="${tenantPrefix}/visitor/visitor-info-list.do"><i class="glyphicon glyphicon-list"></i> 访客管理</a></li>
        </ul>
      </div>
    </div>
  </div>

		<footer id="m-footer" class="text-center">
		  <hr>
		  &copy;Devaeye
		</footer>

</div>
      <!-- end of sidebar -->
