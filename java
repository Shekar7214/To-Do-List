public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {
    private List<ToDoItem> toDoItems;
    private Context context;

    public ToDoListAdapter(Context context, List<ToDoItem> toDoItems) {
        this.context = context;
        this.toDoItems = toDoItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ToDoItem toDoItem = toDoItems.get(position);
        holder.nameTextView.setText(toDoItem.getName());
        holder.completedCheckBox.setChecked(toDoItem.isCompleted());

        holder.completedCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDoItem.setCompleted(holder.completedCheckBox.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return toDoItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public CheckBox completedCheckBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            completedCheckBox = itemView.findViewById(R.id.completedCheckBox);
        }
    }
}
