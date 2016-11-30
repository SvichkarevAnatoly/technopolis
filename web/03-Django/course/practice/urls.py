from django.conf.urls import url

from . import views

app_name = 'practice'
urlpatterns = [
    url(r'^student/$', views.get_student_list, name='student'),
    url(r'^student/add/$', views.add_student, name='add_student'),
    url(r'^student/store/$', views.add_student, name='add_student'),
    url(r'^student/edit/(?P<id>[0-9]+)/$', views.edit_student, name='edit_student'),
    url(r'^student/delete/(?P<id>[0-9]+)/$', views.delete_student, name='delete_student'),
    url(r'^student/save/(?P<id>[0-9]+)/$', views.save_student, name='save_student'),
]
