# Write your MySQL query statement below

select prev.machine_id ,round(avg(curr.timestamp-prev.timestamp),3) as processing_time
from Activity prev
cross join 
Activity curr
where
curr.machine_id=prev.machine_id 
and
curr.process_id=prev.process_id
and
prev.activity_type="start" and curr.activity_type="end"
group by prev.machine_id;